package conta.entidadesBanco;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Conta.class)
public abstract class Conta_ {

	public static volatile SingularAttribute<Conta, Integer> cvv;
	public static volatile SingularAttribute<Conta, Usuario> usuariocpf;
	public static volatile SingularAttribute<Conta, TipoConta> tipoContaId;
	public static volatile SingularAttribute<Conta, String> numeroConta;
	public static volatile SingularAttribute<Conta, Integer> id;
	public static volatile SingularAttribute<Conta, BigDecimal> saldo;
	public static volatile SingularAttribute<Conta, String> vencimento;
	public static volatile SingularAttribute<Conta, String> numeroAgencia;

}

