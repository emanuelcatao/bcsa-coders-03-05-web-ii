package tech.ada.ecommerce.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Produto> buscarTodosOsProdutos(Pageable pageable) {
        try {
            return produtoService.buscarTodosOsProdutos(pageable);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar todos os produtos");
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarProdutoPorId(@PathVariable("id") Long id) {
        try {
            return produtoService.buscarPorId(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto com ID " + id + " não encontrado");
        }
    }

    @GetMapping("/sku/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public Produto buscarProdutoPorSku(@PathVariable("sku") String sku) {
        try {
            return produtoService.buscarPorSku(sku);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto com SKU " + sku + " não encontrado");
        }
    }

    @GetMapping("/nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorNome(@PathVariable("nome") String nome) {
        try {
            return produtoService.buscarPorNome(nome);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar produtos pelo nome " + nome);
        }
    }

    @GetMapping("/preco/faixa-preco")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorFaixaDePreco(
            @RequestParam(value = "minPreco", required = false, defaultValue = "0") double minPreco,
            @RequestParam(value = "maxPreco", required = false, defaultValue = "" + Double.MAX_VALUE) double maxPreco
    ) {
        try {
            return produtoService.buscarPorFaixaDePreco(minPreco, maxPreco);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar produtos pela faixa de preço");
        }
    }

    @GetMapping("/nome/faixa-preco")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarProdutosPorNomeEFaixaDePreco(
            @RequestParam(value = "nome") String nome,
            @RequestParam(value = "minPreco", required = false, defaultValue = "0") double minPreco,
            @RequestParam(value = "maxPreco", required = false, defaultValue = "" + Double.MAX_VALUE) double maxPreco
    ) {
        try {
            return produtoService.buscarPorNomeEPreco(nome, minPreco, maxPreco);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar produtos pelo nome e faixa de preço");
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto criarProduto(@RequestBody Produto produto) {
        try {
            return produtoService.criarOuAtualizarProduto(produto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao criar produto");
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto atualizarProduto(@PathVariable("id") Long id, @RequestBody Produto produtoAtualizado) {
        try {
            return produtoService.atualizarProduto(id, produtoAtualizado);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Erro ao atualizar produto com ID " + id);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable("id") Long id) {
        try {
            produtoService.deletarProduto(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao deletar produto com ID " + id);
        }
    }
}

