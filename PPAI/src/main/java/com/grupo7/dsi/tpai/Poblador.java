package com.grupo7.dsi.tpai;

import com.grupo7.dsi.tpai.models.*;
import com.grupo7.dsi.tpai.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.grupo7.dsi.tpai.service")
public class Poblador implements CommandLineRunner {

    @Autowired private EstadoService estadoService;
    @Autowired private EmpleadoService empleadoService;
    @Autowired private CambioEstadoService cambioEstadoService;
    @Autowired private AlcanceSismoService alcanceSismoService;
    @Autowired private OrigenDeGeneracionService origenDeGeneracionService;
    @Autowired private MagnitudRichterService magnitudRichterService;
    @Autowired private ClasificacionSismoService clasificacionSismoService;
    @Autowired private EventoSismicoService eventoSismicoService;
    @Autowired private EstacionSismologicaService estacionSismologicaService;
    @Autowired private SismografoService sismografoService;
    @Autowired private SerieTemporalService serieTemporalService;
    @Autowired private MuestraSismicaService muestraSismicaService;
    @Autowired
    private UsuarioService usuarioService;

        public static void main(String[] args) {
        // Arranca un contexto Spring ligero SOLO con Poblador
        SpringApplication.run(Poblador.class, args).close();
    }

    @Override
    public void run(String... args) throws Exception {



            Estado estadoPendienteRevision = new Estado();
            estadoPendienteRevision.setAmbito("Evento sismico");
            estadoPendienteRevision.setNombre("Pendiente revision");
            estadoService.save(estadoPendienteRevision);

            Estado estadoConfirmado = new Estado();
            estadoConfirmado.setAmbito("Evento sismico");
            estadoConfirmado.setNombre("Confirmado");
            estadoService.save(estadoConfirmado);

            Estado estadoBloqueado = new Estado();
            estadoBloqueado.setAmbito("Evento sismico");
            estadoBloqueado.setNombre("Bloqueado en revision");
            estadoService.save(estadoBloqueado);

            Estado estadoAutoDetectado = new Estado();
            estadoAutoDetectado.setAmbito("Evento sismico");
            estadoAutoDetectado.setNombre("Auto detectado");
            estadoService.save(estadoAutoDetectado);

            Estado estadoRechazado = new Estado();
            estadoRechazado.setAmbito("Evento sismico");
            estadoRechazado.setNombre("Rechazado");
            estadoService.save(estadoRechazado);

            Empleado empleado = new Empleado();
            empleado.setNombre("Cristian");
            empleado.setApellido("Castro");
            empleado.setTelefono("341-1234567");
            empleado = empleadoService.save(empleado);

            // fechaHoraInicio
            LocalDateTime fechaHoraInicio = LocalDateTime.of(2023, 10, 1, 0, 0);
            LocalDateTime fechaHoraFin = LocalDateTime.of(2023, 10, 1, 23, 59);


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


            // Estación
            EstacionSismologica estacion = new EstacionSismologica();
            estacion.setNombre("Estación Central");
            estacion.setLatitud("-31.42");
            estacion.setLongitud("-64.18");
            estacion.setDocumentoCertificacionAdq("DOC-123");
            estacion.setFechaSolicitudCertificacion(LocalDate.of(2022, 5, 10));
            estacion.setNroCertificacionAdquisicion(101);
            estacion = estacionSismologicaService.save(estacion); // asumimos que tenés este service



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
            evento1.setAnalistaSupervisor(empleado);
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
            evento2.setAnalistaSupervisor(empleado);
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
            evento3.setAnalistaSupervisor(empleado);
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
            evento4.setAnalistaSupervisor(empleado);
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
            evento5.setAnalistaSupervisor(empleado);
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
            evento6.setAnalistaSupervisor(empleado);
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
            evento7.setAnalistaSupervisor(empleado);
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
            evento8.setOrigenGeneracion(origenMendoza); // Mendoza
            evento8.setAnalistaSupervisor(empleado);
            evento8.setAlcanceSismo(alcanceProvincial); // Local
            eventoSismicoService.save(evento8);


            // SerieTemporal 1
            SerieTemporal serie1 = new SerieTemporal();
            serie1.setCondicionAlarma(false);
            serie1.setFrecuenciaMuestreo(1.0f);
            serie1.setFechaHoraRegistro(LocalDateTime.of(2025, 1, 1, 12, 0));
            serie1.setFechaHoraInicioRegistroMuestras(LocalDateTime.of(2025, 1, 1, 12, 0));
            serie1.setEstado(estadoPendienteRevision);

            MuestraSismica muestra1 = new MuestraSismica();
            muestra1.setFechaHoraMuestra(LocalDateTime.of(2025, 1, 1, 12, 0));
            MuestraSismica muestra2 = new MuestraSismica();
            muestra2.setFechaHoraMuestra(LocalDateTime.of(2025, 1, 1, 12, 5));

            List<MuestraSismica> muestrasSerie1 = new ArrayList<>();
            muestrasSerie1.add(muestra1);
            muestrasSerie1.add(muestra2);
            serie1.setMuestrasSismicas(muestrasSerie1);

// SerieTemporal 2
            SerieTemporal serie2 = new SerieTemporal();
            serie2.setCondicionAlarma(true);
            serie2.setFrecuenciaMuestreo(2.0f);
            serie2.setFechaHoraRegistro(LocalDateTime.of(2025, 1, 2, 8, 0));
            serie2.setFechaHoraInicioRegistroMuestras(LocalDateTime.of(2025, 1, 2, 8, 0));
            serie2.setEstado(estadoAutoDetectado);

            MuestraSismica muestra3 = new MuestraSismica();
            muestra3.setFechaHoraMuestra(LocalDateTime.of(2025, 1, 2, 8, 0));
            MuestraSismica muestra4 = new MuestraSismica();
            muestra4.setFechaHoraMuestra(LocalDateTime.of(2025, 1, 2, 8, 10));

            List<MuestraSismica> muestrasSerie2 = new ArrayList<>();
            muestrasSerie2.add(muestra3);
            muestrasSerie2.add(muestra4);
            serie2.setMuestrasSismicas(muestrasSerie2);

// Crear lista mutable para las series
            List<SerieTemporal> seriesSismografo = new ArrayList<>();
            seriesSismografo.add(serie1);
            seriesSismografo.add(serie2);

// Sismógrafo
            Sismografo sismografo = new Sismografo();
            sismografo.setIdentificadorSismografo(1);
            sismografo.setNroSerie(1001);
            sismografo.setFechaAdquisicion(LocalDate.of(2023, 6, 15));
            sismografo.setEstadoActual(estadoPendienteRevision);
            sismografo.setEstacionSismologica(estacion);
            sismografo.setSeriesTemporales(seriesSismografo);

// Agregar más series nuevas de prueba
            for (int i = 0; i < 3; i++) {
                    LocalDateTime inicio = LocalDateTime.of(2025, 5, i + 1, 10, 0);
                    LocalDateTime registro = inicio.plusMinutes(1);
                    boolean alarma = (i % 2) == 1;
                    float frecuencia = 1.5f + i;

                    MuestraSismica m1 = new MuestraSismica();
                    m1.setFechaHoraMuestra(inicio.plusMinutes(5));
                    MuestraSismica m2 = new MuestraSismica();
                    m2.setFechaHoraMuestra(inicio.plusMinutes(10));

                    List<MuestraSismica> muestrasNuevas = new ArrayList<>();
                    muestrasNuevas.add(m1);
                    muestrasNuevas.add(m2);

                    SerieTemporal nuevaSerie = new SerieTemporal();
                    nuevaSerie.setCondicionAlarma(alarma);
                    nuevaSerie.setFrecuenciaMuestreo(frecuencia);
                    nuevaSerie.setFechaHoraInicioRegistroMuestras(inicio);
                    nuevaSerie.setFechaHoraRegistro(registro);
                    nuevaSerie.setEstado(estadoPendienteRevision);
                    nuevaSerie.setMuestrasSismicas(muestrasNuevas);

                    sismografo.getSeriesTemporales().add(nuevaSerie);
            }

            // Asignar series del sismógrafo al evento1
            List<SerieTemporal> seriesParaEvento = new ArrayList<>(sismografo.getSeriesTemporales());
            evento1.setSeriesTemporal(seriesParaEvento);
            eventoSismicoService.save(evento1);

            sismografoService.save(sismografo);

            Usuario usuario = new Usuario();
            usuario.setEmpleado(empleado);
            usuario.setNombreUsuario("Cristulo");
            usuarioService.save(usuario);

        };
    }
