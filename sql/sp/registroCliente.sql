SELECT DISTINCT
    c.id,
    CASE WHEN (c.tipo = 0) THEN 
        'Persona'
    ELSE 
        'Empresa'
    END AS 'tipo',
    ISNULL(p.nombre + ' ' + p.apellido, e.razon_social) AS 'nombre_razon',
    ISNULL(p.DNI, e.CUIT) AS 'DNI_CUIT',
    e.inicio_actividad,
    (SELECT razon_social
     FROM empresa
     INNER JOIN empresa_persona ON empresa_persona.idEmpresa = empresa.id
     AND empresa_persona.idPersona = p.id) AS 'pertenece_a'
FROM
    cliente c
LEFT JOIN empresa e ON e.idCliente = c.id
LEFT JOIN persona p ON p.idCliente = c.id