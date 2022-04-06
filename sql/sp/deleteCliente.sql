IF EXISTS (
    SELECT 1
        FROM INFORMATION_SCHEMA.ROUTINES
    WHERE SPECIFIC_SCHEMA = N'dbo'
        AND SPECIFIC_NAME = N'deleteCliente'
        AND ROUTINE_TYPE = N'PROCEDURE'
)
DROP PROCEDURE dbo.deleteCliente
GO

CREATE PROCEDURE dbo.deleteCliente
    @idCliente int = 0,
    @idSubCliente int = 0,
    @tipoCliente SMALLINT
AS
BEGIN

    IF (@tipoCliente = 0) 

        BEGIN

            DELETE per
            FROM persona per
            WHERE per.id = @idSubCliente

            DELETE emp_per
            FROM empresa_persona emp_per
            WHERE emp_per.idPersona = @idSubCliente

        END

    ELSE

        BEGIN

            DELETE emp
            FROM empresa emp
            WHERE emp.id = @idSubCliente

            DELETE emp_per
            FROM empresa_persona emp_per
            WHERE emp_per.idPersona = @idSubCliente

        END

    DELETE cl
    FROM cliente cl
    WHERE cl.id = @idSubCliente

    SELECT 1

END
GO