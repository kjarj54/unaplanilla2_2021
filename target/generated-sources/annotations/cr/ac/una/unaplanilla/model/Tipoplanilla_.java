package cr.ac.una.unaplanilla.model;

import cr.ac.una.unaplanilla.model.Empleado;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.8.v20201217-rNA", date="2021-06-13T16:10:06")
@StaticMetamodel(Tipoplanilla.class)
public class Tipoplanilla_ { 

    public static volatile SingularAttribute<Tipoplanilla, String> descripcion;
    public static volatile SingularAttribute<Tipoplanilla, String> codigo;
    public static volatile SingularAttribute<Tipoplanilla, Integer> numUltPla;
    public static volatile SingularAttribute<Tipoplanilla, String> estado;
    public static volatile SingularAttribute<Tipoplanilla, Integer> mesUltPla;
    public static volatile SingularAttribute<Tipoplanilla, Integer> planillasMes;
    public static volatile ListAttribute<Tipoplanilla, Empleado> empleados;
    public static volatile SingularAttribute<Tipoplanilla, Long> id;
    public static volatile SingularAttribute<Tipoplanilla, Integer> anoUltPla;
    public static volatile SingularAttribute<Tipoplanilla, Integer> version;

}