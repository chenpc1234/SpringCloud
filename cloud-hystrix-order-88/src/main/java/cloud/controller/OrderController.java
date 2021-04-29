package cloud.controller;

import cloud.service.IPaymentService;
import com.chen.cloud.entities.CommonResult;
import com.chen.cloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/29/04/29  17:45
 */
@RestController
public class OrderController {
    @Autowired
    private IPaymentService paymentService;

    @GetMapping("/consumer/seeOk/{id}")
    public CommonResult<Payment> seeOk(@PathVariable("id") Long id){

        return paymentService.seeOk(id);
    }

}
