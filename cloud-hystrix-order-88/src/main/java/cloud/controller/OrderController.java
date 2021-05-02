package cloud.controller;

import cloud.service.IPaymentService;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/29/04/29  17:45
 */
@RestController
@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/consumer/seeOk/{id}")
    public CommonResult<Payment> seeOk(@PathVariable("id") int id){

        return paymentService.seeOk(id);
    }

    /**
     * 服务降级 方法1（需要降级的method上单独配置 很傻逼） ：消费者 2s内必须执行完方法
     * @param id id
     * @return  返回值
     */
    @GetMapping("/consumer/seeOk/seeOkOut/{id}")
    @HystrixCommand(fallbackMethod = "fallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
    })
    public CommonResult<Payment> seeOkTimeOut(@PathVariable("id") int id){
        return paymentService.seeOkTimeOut(id);
    }

    public CommonResult<Payment> fallback(@PathVariable("id") int id){
        return new CommonResult<>(300, "出错啦！！！ 服务提供者8100 2s 没给我数据");
    }

    /**
     * 服务降级方法2  (也不行)：
     * 1.类上标注@DefaultProperties(defaultFallback = "globalFallback")  指定默认的fallback 方法
     * 2. 方法只标注   @HystrixCommand 没有指定 fallbackMethod 的值 ，降级会调用默认的方法
     * 3.默认方法的返回值 必须和 需要降级的方法返回值一致，否者会报错
     * @param id id
     * @return 信息
     */
    @GetMapping("/consumer/seeOk/seeOkOut2/{id}")
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "2000")
//    })
    @HystrixCommand
    public CommonResult<Payment> seeOkTimeOut2(@PathVariable("id") int id){
        return paymentService.seeOkTimeOut(id);
    }


    public CommonResult<Payment> globalFallback(){
        return new CommonResult<>(300, "全局服务降级");
    }

}
