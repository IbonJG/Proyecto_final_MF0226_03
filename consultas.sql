use mf0226_3;

select nombre, apellidos, cod_curso, resenia_valoracion, resenia_descripcion from alumno
inner join participantes on alumno.id_alumno = participantes.id_alumno
where alumno.id_alumno = 1
;

/*Todos los cursos realizados ordenados cronológicamente que muestre los siguientes campos:
1.1. nombre del curso
1.2. identificador del curso
1.3. número de horas del curso
1.4. profesor del curso ( nombre, apellido )
*/

select imparticiones.fecha_inicio, curso.nombre as curso, imparticiones.cod_curso as identificador, curso.horas, profesor.nombre as nombre_profesor, profesor.apellidos as apellido_profesor from curso
inner join imparticiones on curso.id_curso = imparticiones.id_curso
inner join profesor on imparticiones.id_profesor = profesor.id_profesor
order by imparticiones.fecha_inicio desc;

/*
	Detalle de un curso, junto con las reseñas de los usuarios
*/

select profesor.nombre as nombre_profesor, profesor.apellidos as apellidos_profesor , curso.nombre as curso, imparticiones.cod_curso, imparticiones.fecha_inicio, imparticiones.fecha_fin, curso.horas,
	alumno.nombre alumno_nombre, alumno.apellidos as alumno_apellido, participantes.resenia_valoracion, participantes.resenia_descripcion
    from curso
    inner join imparticiones on curso.id_curso = imparticiones.id_curso
    inner join profesor on imparticiones.id_profesor = profesor.id_profesor
    inner join participantes on imparticiones.cod_curso = participantes.cod_curso
    inner join alumno on participantes.id_alumno = alumno.id_alumno
    -- where imparticiones.id_curso = 3;
    where imparticiones.cod_curso = 'DESWEB-45'
    ;


-- SQL listar últimos 5 cursos
select curso.nombre, curso.horas, imparticiones.cod_curso, imparticiones.fecha_inicio, imparticiones.fecha_fin from curso
inner join imparticiones on curso.id_curso = imparticiones.id_curso
order by imparticiones.fecha_fin desc
limit 5;


-- listar últimos 5 usuarios creados
select alumno.id_alumno, alumno.nombre, alumno.apellidos from alumno
order by id_alumno desc
limit 5;

-- detalle curso más número de reseñas
select curso.nombre as curso, imparticiones.cod_curso, count(participantes.resenia_valoracion) as num_resenias from curso
inner join imparticiones on curso.id_curso = imparticiones.id_curso
inner join participantes on imparticiones.cod_curso = participantes.cod_curso
group by participantes.cod_curso
order by num_resenias desc
limit 1
;

-- cursos con mejor media de resenias



