package servicios;

import modelo.BeanCoche;
import modelo.DaoCoche;
import utils.ResultAction;

import java.util.List;

public class ServiceCoche {
    DaoCoche daoCoche = new DaoCoche();

    public List<BeanCoche> getAll(){
        return daoCoche.findAll();
    }

    public ResultAction save(BeanCoche coche){
        ResultAction result = new ResultAction();
        if (daoCoche.save(coche)){
            result.setResult(true);
            result.setMessage("Coche Registrado");
            result.setStatus(200);
        }else {
            result.setResult(false);
            result.setMessage("Ocurrió un error al registrar");
            result.setStatus(400);
        }
        return result;
    }

    public BeanCoche getCoche(Long id){
        return daoCoche.findOne(id);
    }

    public ResultAction update(BeanCoche coche){
        ResultAction result = new ResultAction();
        if (daoCoche.update(coche)){
            result.setStatus(200);
            result.setResult(false);
            result.setMessage("Coche Actualizado");
        }else{
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrió un error en la Actualizacion");
        }
        return result;
    }

    public ResultAction delete(String id){
        ResultAction result = new ResultAction();
        try{
            if (daoCoche.delete(Long.parseLong(id))){
                result.setStatus(200);
                result.setResult(false);
                result.setMessage("Coche Eliminado correctamente");
            }else{
                result.setStatus(400);
                result.setResult(true);
                result.setMessage("Ocurrió un error al Eliminar");
            }
        }catch (NumberFormatException e){
            result.setStatus(400);
            result.setResult(true);
            result.setMessage("Ocurrió un error");
        }
        return result;
    }
}