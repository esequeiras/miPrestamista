package cr.fi.migarrotera;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import javax.inject.Named;

@Named
public class ValidarMonto implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        int monto = (int) delegateExecution.getVariable("monto");
        int ingreso = (int) delegateExecution.getVariable("ingreso");
        String prenda = (String) delegateExecution.getVariable("prenda");

        //monto inferior al 80%
        double total = ingreso * 0.8;
        if (monto < total ) {

            delegateExecution.setVariable("montoAprobado", monto);
        } else if (prenda.equals("no")){


            delegateExecution.setVariable("montoAprobado", "Su prestamo no fue aprobado");

        }
    }

}
