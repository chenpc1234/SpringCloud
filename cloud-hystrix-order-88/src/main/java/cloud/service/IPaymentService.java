package cloud.service;

import com.chen.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/27/04/27  16:42
 */
@FeignClient(value = "CLOUD-HYSTRIX-PAYMENT-SERVICE")
@Component
public interface IPaymentService {
    /**
     * seeOk
     * @param id seeOk
     * @return seeOk
     */
    @GetMapping("/seeOK/{id}")
    public CommonResult seeOk(@PathVariable("id") Long id);
}
