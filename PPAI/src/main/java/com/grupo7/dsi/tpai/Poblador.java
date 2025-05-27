package com.grupo7.dsi.tpai;

import com.grupo7.dsi.tpai.controllers.RegistrarRevisionManualController;
import com.grupo7.dsi.tpai.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Poblador {


    public static void main(String[] args) {
        SpringApplication.run(Springboot.class, args);
    }

    // Esta clase se ejecuta para guardar objetos en la base de datos, se inyectan los servicios.

    //@Bean
    public CommandLineRunner initData(RegistrarRevisionManualController gestorCrudRevisionManual,
                                      EventoSismicoService eventoSismicoService,
                                      EstadoService estadoService,
                                      AlcanceSismoService alcanceSismoService,
                                      OrigenDeGeneracionService origenDeGeneracionService,
                                      MagnitudRichterService magnitudRichterService,
                                      ClasificacionSismoService clasificacionSismoService,
                                      CambioEstadoService cambioEstadoService,
                                      EmpleadoService empleadoService) {
        return args -> {


            /*
            Estado estadoPendienteRevision = new Estado();
            estadoPendienteRevision.setAmbito("Evento sismico");
            estadoPendienteRevision.setNombre("Pendiente revision");
            estadoService.save(estadoPendienteRevision);

            Estado estadoConfirmado = new Estado();
            estadoConfirmado.setAmbito("Evento sismico");
            estadoConfirmado.setNombre("Confirmado");

            Estado estadoAutoDetectado = new Estado();
            estadoAutoDetectado.setAmbito("Evento sismico");
            estadoAutoDetectado.setNombre("Auto detectado");
            estadoService.save(estadoAutoDetectado);

            Estado estadoRechazado = new Estado();
            estadoRechazado.setAmbito("Evento sismico");
            estadoRechazado.setNombre("Rechazado");
            estadoService.save(estadoRechazado);


            // fechaHoraInicio
            LocalDateTime fechaHoraInicio = LocalDateTime.of(2023, 10, 1, 0, 0);
            LocalDateTime fechaHoraFin = LocalDateTime.of(2023, 10, 1, 23, 59);

            // Empleado
            Empleado empleado1 = new Empleado();
            empleado1.setNombre("Cristian");
            empleado1.setApellido("Castro");
            empleado1.setTelefono("341-1234567");
            empleadoService.save(empleado1);

            // Cambios de estado
            CambioEstado cambioEstado1 = new CambioEstado();
            cambioEstado1.setFechaHoraInicio(fechaHoraInicio);
            cambioEstado1.setEstadoNombre("Pendiente revision");
            cambioEstado1.setEstadoAmbito("Evento sismico");
            cambioEstado1.setEstado(estadoPendienteRevision);
            cambioEstadoService.save(cambioEstado1);

            CambioEstado cambioEstado2 = new CambioEstado();
            cambioEstado2.setFechaHoraInicio(fechaHoraInicio);
            cambioEstado2.setEstadoAmbito("Evento sismico");
            cambioEstado2.setEstadoNombre(estadoConfirmado.getNombre());
            cambioEstado2.setEstado(estadoConfirmado);
            cambioEstado2.setFechaHoraFin(fechaHoraFin);
            cambioEstadoService.save(cambioEstado2);

            CambioEstado cambioEstado3 = new CambioEstado();
            cambioEstado3.setFechaHoraInicio(fechaHoraInicio);
            cambioEstado3.setEstadoAmbito("Evento sismico");
            cambioEstado3.setEstadoNombre(estadoAutoDetectado.getNombre());
            cambioEstado3.setEstado(estadoAutoDetectado);
            cambioEstado3.setFechaHoraFin(fechaHoraFin);
            cambioEstadoService.save(cambioEstado3);


            List<CambioEstado> cambiosEstado = new ArrayList<>();
            cambiosEstado.add(cambioEstado1);
            cambiosEstado.add(cambioEstado2);
            cambiosEstado.add(cambioEstado3);




            // Alcance
            AlcanceSismo alcanceRegional = new AlcanceSismo();
            alcanceRegional.setNombre("Regional");
            alcanceRegional.setDescripcion("Afecta una región amplia");
            alcanceSismoService.save(alcanceRegional);

            AlcanceSismo alcanceInternacional = new AlcanceSismo();
            alcanceInternacional.setNombre("Internacional");
            alcanceInternacional.setDescripcion("Sismo sentido en varios países");
            alcanceSismoService.save(alcanceInternacional);

            AlcanceSismo alcanceProvincial = new AlcanceSismo();
            alcanceProvincial.setNombre("Provincial");
            alcanceProvincial.setDescripcion("Afecta a una sola provincia");
            alcanceSismoService.save(alcanceProvincial);

            // Origen de Generación
            OrigenDeGeneracion origenSanJuan = new OrigenDeGeneracion();
            origenSanJuan.setNombre("San Juan");
            origenSanJuan.setDescripcion("Zona sísmica activa");
            origenDeGeneracionService.save(origenSanJuan);

            OrigenDeGeneracion origenMendoza = new OrigenDeGeneracion();
            origenMendoza.setNombre("Mendoza");
            origenMendoza.setDescripcion("Zona cordillerana, alto riesgo sísmico");
            origenDeGeneracionService.save(origenMendoza);

            OrigenDeGeneracion origenSalta = new OrigenDeGeneracion();
            origenSalta.setNombre("Salta");
            origenSalta.setDescripcion("Actividad sísmica frecuente en el noroeste");
            origenDeGeneracionService.save(origenSalta);

            // Magnitud
            MagnitudRichter magnitudMedia = new MagnitudRichter();
            magnitudMedia.setNumero(4.0f);
            magnitudMedia.setDescripcionMagnitud("Moderada");
            magnitudRichterService.save(magnitudMedia);

            MagnitudRichter magnitudAlta = new MagnitudRichter();
            magnitudAlta.setNumero(6.5f);
            magnitudAlta.setDescripcionMagnitud("Fuerte");
            magnitudRichterService.save(magnitudAlta);

            MagnitudRichter magnitudLeve = new MagnitudRichter();
            magnitudLeve.setNumero(1.8f);
            magnitudLeve.setDescripcionMagnitud("Leve, apenas perceptible");
            magnitudRichterService.save(magnitudLeve);

            MagnitudRichter magnitudSevera = new MagnitudRichter();
            magnitudSevera.setNumero(7.2f);
            magnitudSevera.setDescripcionMagnitud("Muy severa");
            magnitudRichterService.save(magnitudSevera);

            // Clasificación
            ClasificacionSismo clasificacionModerada = new ClasificacionSismo();
            clasificacionModerada.setNombre("Moderado");
            clasificacionModerada.setKmProfundidadDesde(10.1f);
            clasificacionModerada.setKmProfundidadHasta(70.0f);
            clasificacionSismoService.save(clasificacionModerada);

            ClasificacionSismo clasificacionProfunda = new ClasificacionSismo();
            clasificacionProfunda.setNombre("Profundo");
            clasificacionProfunda.setKmProfundidadDesde(70.1f);
            clasificacionProfunda.setKmProfundidadHasta(300.0f);
            clasificacionSismoService.save(clasificacionProfunda);

            ClasificacionSismo clasificacionSuperficial = new ClasificacionSismo();
            clasificacionSuperficial.setNombre("Superficial");
            clasificacionSuperficial.setKmProfundidadDesde(0.0f);
            clasificacionSuperficial.setKmProfundidadHasta(20.0f);
            clasificacionSismoService.save(clasificacionSuperficial);

            ClasificacionSismo clasificacionIntermedia = new ClasificacionSismo();
            clasificacionIntermedia.setNombre("Intermedia");
            clasificacionIntermedia.setKmProfundidadDesde(20.1f);
            clasificacionIntermedia.setKmProfundidadHasta(70.0f);
            clasificacionSismoService.save(clasificacionIntermedia);

            // Evento Sismico 1
            EventoSismico evento1 = new EventoSismico();
            evento1.setFechaHoraOcurrencia(LocalDateTime.of(2024, 7, 20, 2, 30));
            evento1.setFechaHoraFin(LocalDateTime.of(2024, 7, 20, 3, 0));
            evento1.setLatitudEpicentro("30.1");
            evento1.setLongitudEpicentro("66.9");
            evento1.setLatitudHipocentro("30.2");
            evento1.setLongitudHipocentro("66.95");
            evento1.setValorMagnitud(4.0f);
            evento1.setEstadoActual(estadoPendienteRevision);
            evento1.setCambiosEstado(cambiosEstado);
            evento1.setClasificacion(clasificacionModerada);
            evento1.setMagnitud(magnitudMedia);
            evento1.setOrigenGeneracion(origenSanJuan);
            evento1.setAlcanceSismo(alcanceRegional);
            eventoSismicoService.save(evento1);

// Evento Sismico 2
            EventoSismico evento2 = new EventoSismico();
            evento2.setFechaHoraOcurrencia(LocalDateTime.of(2023, 12, 15, 18, 10));
            evento2.setFechaHoraFin(LocalDateTime.of(2023, 12, 15, 18, 50));
            evento2.setLatitudEpicentro("-31.42");
            evento2.setLongitudEpicentro("-64.18");
            evento2.setLatitudHipocentro("-31.45");
            evento2.setLongitudHipocentro("-64.20");
            evento2.setValorMagnitud(6.5f);
            evento2.setEstadoActual(estadoPendienteRevision);
            evento2.setCambiosEstado(cambiosEstado);
            evento2.setClasificacion(clasificacionProfunda);
            evento2.setMagnitud(magnitudAlta);
            evento2.setOrigenGeneracion(origenSanJuan);
            evento2.setAlcanceSismo(alcanceRegional);
            eventoSismicoService.save(evento2);

            EventoSismico evento3 = new EventoSismico();
            evento3.setFechaHoraOcurrencia(LocalDateTime.of(2024, 1, 5, 6, 15));
            evento3.setFechaHoraFin(LocalDateTime.of(2024, 1, 5, 6, 45));
            evento3.setLatitudEpicentro("-32.5");
            evento3.setLongitudEpicentro("-68.9");
            evento3.setLatitudHipocentro("-32.6");
            evento3.setLongitudHipocentro("-69.0");
            evento3.setValorMagnitud(7.2f);
            evento3.setEstadoActual(estadoPendienteRevision);
            evento3.setCambiosEstado(cambiosEstado);
            evento3.setClasificacion(clasificacionIntermedia);
            evento3.setMagnitud(magnitudSevera);
            evento3.setOrigenGeneracion(origenMendoza);
            evento3.setAlcanceSismo(alcanceInternacional);
            eventoSismicoService.save(evento3);

            EventoSismico evento4 = new EventoSismico();
            evento4.setFechaHoraOcurrencia(LocalDateTime.of(2023, 11, 2, 3, 20));
            evento4.setFechaHoraFin(LocalDateTime.of(2023, 11, 2, 3, 40));
            evento4.setLatitudEpicentro("-24.78");
            evento4.setLongitudEpicentro("-65.41");
            evento4.setLatitudHipocentro("-24.80");
            evento4.setLongitudHipocentro("-65.45");
            evento4.setValorMagnitud(1.8f);
            evento4.setEstadoActual(estadoAutoDetectado);
            evento4.setClasificacion(clasificacionSuperficial);
            evento4.setMagnitud(magnitudLeve);
            evento4.setOrigenGeneracion(origenSalta);
            evento4.setAlcanceSismo(alcanceProvincial);
            eventoSismicoService.save(evento4);

            EventoSismico evento5 = new EventoSismico();
            evento5.setFechaHoraOcurrencia(LocalDateTime.of(2025, 3, 10, 12, 0));
            evento5.setFechaHoraFin(LocalDateTime.of(2025, 3, 10, 12, 30));
            evento5.setLatitudEpicentro("-31.42");
            evento5.setLongitudEpicentro("-64.18");
            evento5.setLatitudHipocentro("-31.43");
            evento5.setLongitudHipocentro("-64.19");
            evento5.setValorMagnitud(2.5f);
            evento5.setEstadoActual(estadoPendienteRevision);
            evento5.setCambiosEstado(cambiosEstado);
            evento5.setClasificacion(clasificacionSuperficial);
            evento5.setMagnitud(magnitudAlta); // el original 2.5f
            evento5.setOrigenGeneracion(origenSalta); // Cordoba
            evento5.setAlcanceSismo(alcanceProvincial); // Local
            eventoSismicoService.save(evento5);

            EventoSismico evento6 = new EventoSismico();
            evento6.setFechaHoraOcurrencia(LocalDateTime.of(2025, 6, 15, 9, 0));
            evento6.setFechaHoraFin(LocalDateTime.of(2025, 6, 15, 9, 25));
            evento6.setLatitudEpicentro("-24.79");
            evento6.setLongitudEpicentro("-65.42");
            evento6.setLatitudHipocentro("-24.80");
            evento6.setLongitudHipocentro("-65.44");
            evento6.setValorMagnitud(1.8f);
            evento6.setEstadoActual(estadoPendienteRevision);
            evento6.setCambiosEstado(cambiosEstado);
            evento6.setClasificacion(clasificacionSuperficial);
            evento6.setMagnitud(magnitudLeve);
            evento6.setOrigenGeneracion(origenSalta);
            evento6.setAlcanceSismo(alcanceProvincial);
            eventoSismicoService.save(evento6);

            EventoSismico evento7 = new EventoSismico();
            evento7.setFechaHoraOcurrencia(LocalDateTime.of(2025, 7, 1, 21, 15));
            evento7.setFechaHoraFin(LocalDateTime.of(2025, 7, 1, 21, 45));
            evento7.setLatitudEpicentro("-32.52");
            evento7.setLongitudEpicentro("-68.85");
            evento7.setLatitudHipocentro("-32.53");
            evento7.setLongitudHipocentro("-68.87");
            evento7.setValorMagnitud(7.2f);
            evento7.setEstadoActual(estadoPendienteRevision);
            evento7.setCambiosEstado(cambiosEstado);
            evento7.setClasificacion(clasificacionIntermedia);
            evento7.setMagnitud(magnitudSevera);
            evento7.setOrigenGeneracion(origenMendoza);
            evento7.setAlcanceSismo(alcanceInternacional);
            eventoSismicoService.save(evento7);

            EventoSismico evento8 = new EventoSismico();
            evento8.setFechaHoraOcurrencia(LocalDateTime.of(2025, 8, 20, 4, 0));
            evento8.setFechaHoraFin(LocalDateTime.of(2025, 8, 20, 4, 20));
            evento8.setLatitudEpicentro("-31.40");
            evento8.setLongitudEpicentro("-64.17");
            evento8.setLatitudHipocentro("-31.41");
            evento8.setLongitudHipocentro("-64.18");
            evento8.setValorMagnitud(2.5f);
            evento8.setEstadoActual(estadoPendienteRevision);
            evento8.setCambiosEstado(cambiosEstado);
            evento8.setClasificacion(clasificacionIntermedia); // Clasificacion 1
            evento8.setMagnitud(magnitudLeve); // 2.5f
            evento8.setOrigenGeneracion(origenMendoza); // Cordoba
            evento8.setAlcanceSismo(alcanceProvincial); // Local
            eventoSismicoService.save(evento8);

*/

        };
    }

}
