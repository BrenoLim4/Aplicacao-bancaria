
package conta.interfaces;

import java.math.BigDecimal;

/**
 *
 * @author User
 */
public interface ContaMovimentavel {
    
    public static final BigDecimal TAXA_SAQUE = new BigDecimal(6.5);
    BigDecimal sacar();    
    BigDecimal getSaldo();
    void depositar();
    void transferir();  
}
