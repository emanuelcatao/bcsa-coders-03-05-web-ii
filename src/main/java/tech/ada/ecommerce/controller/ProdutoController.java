package tech.ada.ecommerce.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProdutoController {

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping("/produtos")
    public Page<Produto> buscarTodosOsProdutos(Pageable pageable) {
        logger.info("Buscando todos os produtos");
        return produtoService.buscarTodosOsProdutos(pageable);
    }

    @GetMapping("/produtos/{id}")
    public Produto buscarProdutoPorId(@PathVariable("id") Long id) {
        logger.info("Buscando produto pelo ID: " + id);
        return produtoService.buscarPorId(id);
    }

    @GetMapping("/produtos/sku/{sku}")
    public Produto buscarProdutoPorSku(@PathVariable("sku") String sku) {
        logger.info("Buscando produto pelo SKU: " + sku);
        return produtoService.buscarPorSku(sku);
    }

    @GetMapping("/produtos/nome/{nome}")
    public List<Produto> buscarProdutosPorNome(@PathVariable("nome") String nome) {
        logger.info("Buscando produtos pelo nome: " + nome);
        return produtoService.buscarPorNome(nome);
    }

    @GetMapping("/produtos/faixa-preco")
    public List<Produto> buscarProdutosPorFaixaDePreco(
            @RequestParam(value = "minPreco", required = false, defaultValue = "0") double minPreco,
            @RequestParam(value = "maxPreco", required = false, defaultValue = "" + Double.MAX_VALUE) double maxPreco
            )
    {
        logger.info("Buscando produtos pela faixa de preço: " + minPreco + " - " + maxPreco);
        return produtoService.buscarPorFaixaDePreco(minPreco, maxPreco);
    }
    @PostMapping("/produtos")
    public Produto criarProduto(@RequestBody Produto produto) {
        logger.info("Criando novo produto");
        return produtoService.criarOuAtualizarProduto(produto);
    }
}
