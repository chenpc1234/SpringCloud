package cloud.controller;

import cloud.service.IPaymentService;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/29/04/29  23:41
 */
@RestController
public class SeeHello {

    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/consumer/see/{id}")
    public CommonResult<Payment> see(@PathVariable("id") int id){
        return paymentService.seeOkTimeOut(id);
    }

}
