package com.app_soft_vendas_backend.adapter.in.web;

import com.app_soft_vendas_backend.adapter.in.web.dto.request.PedidoRequest;
import com.app_soft_vendas_backend.application.port.in.PedidoUseCase;
import com.app_soft_vendas_backend.application.port.in.dto.request.CriarPedidoCommand;
import com.app_soft_vendas_backend.application.port.in.dto.request.ItemCommand;
import com.app_soft_vendas_backend.application.port.in.dto.response.PedidoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    public PedidoController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<PedidoResponse> criar(
            @AuthenticationPrincipal Jwt jwt,
            @RequestBody PedidoRequest request
    ) {

        List<ItemCommand> itens = request.itens().stream()
                .map(i -> new ItemCommand(i.produtoId(), i.quantidade()))
                .toList();

        CriarPedidoCommand command = new CriarPedidoCommand(jwt.getSubject(), itens);

        PedidoResponse response = pedidoUseCase.criarPedido(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<PedidoResponse>> buscarPedidos(
            @AuthenticationPrincipal Jwt jwt
    ) {

        List<PedidoResponse> response = pedidoUseCase.buscarPedidos(jwt.getSubject());

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}