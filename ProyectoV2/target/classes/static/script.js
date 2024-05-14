$(document).ready(function() {
    // Función para calcular el total y habilitar el botón de enviar
    function calcularTotalYHabilitarBoton() {
        var donacion = parseFloat($("input[name='donacion']").val()) || 0;
        var ingreso = parseFloat($("input[name='ingreso']").val()) || 0;
        var gasto = parseFloat($("input[name='gasto']").val()) || 0;

        var total = (donacion + ingreso) - gasto;
        $("#total").val(total.toFixed(2));

        // Habilitar o deshabilitar el botón de enviar según si se han llenado todos los campos
        var botonEnviar = $("button[type='button']");
        if (donacion !== 0 && ingreso !== 0 && gasto !== 0) {
            botonEnviar.prop("disabled", false);
        } else {
            botonEnviar.prop("disabled", true);
        }
    }

    // Llama a la función calcularTotalYHabilitarBoton al cargar la página y cada vez que se modifica alguno de los campos
    calcularTotalYHabilitarBoton();
    $("input[name='donacion'], input[name='ingreso'], input[name='gasto']").on("input", calcularTotalYHabilitarBoton);
});

function enviarPresupuesto() {
    // Obtener los datos del formulario
    var donacion = $("input[name='donacion']").val();
    var ingreso = $("input[name='ingreso']").val();
    var gasto = $("input[name='gasto']").val();
    var total = $("input[name='total']").val();

    // Crear el objeto de datos a enviar al backend
    var datos = {
        donacion: donacion,
        ingreso: ingreso,
        gasto: gasto,
        total: total
    };

    // Realizar la solicitud AJAX al backend de Spring Boot
    $.ajax({
        type: "POST",
        url: "/guardarPresupuesto", 
        contentType: "application/json",
        data: JSON.stringify(datos),
        success: function(response) {
            alert("Presupuesto guardado exitosamente");
            // Puedes redirigir a otra página si lo deseas
            // window.location.href = "/ruta-de-destino";
        },
        error: function(xhr, status, error) {
            console.error(xhr.responseText);
            alert("Error al guardar el presupuesto");
        }
    });


}
