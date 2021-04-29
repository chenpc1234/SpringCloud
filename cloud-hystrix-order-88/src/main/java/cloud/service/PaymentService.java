package cloud.service;

import com.chen.cloud.entities.CommonResult;

/**
 * @author chenpc
 * @version 1.0
 * @since 2021/4/29/04/29  17:51
 */

public class PaymentService implements IPaymentService{
    @Override
    public CommonResult seeOk(Long id) {
        return new CommonResult(500, "服务不可用", "服务不可用") ;
    }
}
