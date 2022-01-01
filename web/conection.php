<?php

    $conexion = mysqli_connect("localhost", "pollo","12345678","prueba3") or die(mysqli_error(($mysql)));

    $cantidad = $_POST ['cantidad'];
    $plato = $_POST ['producto'];

    $sql = "SELECT id_cliente FROM cliente order by id_cliente DESC LIMIT 1";

    
    $clave_forranea = mysqli_query($conexion, $sql);
    $id_cliente = mysqli_fetch_array($clave_forranea, MYSQLI_ASSOC);

    $clave = $id_cliente['id_cliente'] + 1;


    function obtenerTotalAcancelar($cantidad, $plato){
        $precio_total_cancelar = 0;
        $economico = 10;
        $cuarto = 20;
        $medio = 40;
        $entero = 80;

        if ($plato == "ECONOMICO"){
            $precio_total_cancelar = $cantidad * $economico;
            return $precio_total_cancelar;
        }
        elseif ($plato == "CUARTO") {
            $precio_total_cancelar = $cantidad * $cuarto;
            return $precio_total_cancelar;
        }
        elseif ($plato == "MEDIO"){
            $precio_total_cancelar = $cantidad * $medio;
            return $precio_total_cancelar;
        }
        elseif ($plato == "ENTERO") {   
            $precio_total_cancelar = $cantidad * $entero;
            return $precio_total_cancelar;
        };
    };

    $totalObtenido = obtenerTotalAcancelar($cantidad,$plato);
    

    function insertar($conexion, $cantidad, $plato, $totalObtenido, $clave){


        $consulta = "INSERT INTO cliente(id_cliente) VALUE(null)";
        $consulta2 = "INSERT INTO mesa(id_mesa, activo_o_no) VALUES(null, 1)";




        $consulta3 = "INSERT INTO factura(id_factura, total, tipo, cantidad) VALUES(null, $totalObtenido, '$plato', $cantidad)";
        $consulta4 = "INSERT INTO pedido(id_pedido, tipo_plato, cantidad, precio, id_relacion_solicitud, estado) VALUES(null, '$plato', $cantidad, $totalObtenido, $clave, 1)";

        $consulta5 = "INSERT INTO genera(id_genera, id_relacion_pedido, id_relacion_factura) VALUES (null, '$clave', '$clave')";

        $consulta6 = "INSERT INTO `solicitud` (`id_solicitud`, `id_relacion_cliente`, `id_relacion_mesa`) VALUES (NULL, '$clave', '$clave')";

        $ultimaConsulta = "INSERT INTO registro(id_registro, tipo_plato, cantidad, precio, estado) VALUES (NULL, '$plato', $cantidad, $totalObtenido, 1)";
     
   

        mysqli_query($conexion, $consulta); #cliente  1
        mysqli_query($conexion, $consulta2); #mesa    2
        sleep(1);
        mysqli_query($conexion, $consulta6); #solicitud  6

        mysqli_query($conexion, $consulta4); #pedido  4

        mysqli_query($conexion, $consulta3);  #   3
        mysqli_query($conexion, $consulta5);  #   5

        mysqli_query($conexion, $ultimaConsulta);
       

        mysqli_close($conexion);
    };
    insertar($conexion, $cantidad, $plato, $totalObtenido, $clave);
   

    header('Location: index.html');


?>