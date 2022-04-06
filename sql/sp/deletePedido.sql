IF EXISTS (
    SELECT 1
        FROM INFORMATION_SCHEMA.ROUTINES
    WHERE SPECIFIC_SCHEMA = N'dbo'
        AND SPECIFIC_NAME = N'deletePedido'
        AND ROUTINE_TYPE = N'PROCEDURE'
)
DROP PROCEDURE dbo.deletePedido
GO

CREATE PROCEDURE dbo.deletePedido
    @idPedido int = 0,
    @idSubPedido int = 0,
    @tipoPedido SMALLINT
AS
BEGIN

    IF (@tipoPedido = 0) 

        BEGIN

            DELETE prod
            FROM producto prod
            WHERE prod.id = @idSubPedido

            DELETE ped_prod
            FROM pedido_producto ped_prod
            WHERE ped_prod.idProducto = @idSubPedido

        END

    ELSE

        BEGIN

            DELETE serv
            FROM servicio serv
            WHERE serv.id = @idSubPedido

            DELETE ped_serv
            FROM pedido_servicio ped_serv
            WHERE ped_serv.idServicio = @idSubPedido

        END

    DELETE ped
    FROM pedido ped
    WHERE ped.id = @idPedido

    SELECT 1

END
GO

