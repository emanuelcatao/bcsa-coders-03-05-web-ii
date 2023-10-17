package tech.ada.ecommerce.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.ada.ecommerce.model.Produto;
import tech.ada.ecommerce.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> buscarTodosOsProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    public Produto buscarPorId(Long id) {
        Optional<Produto> produto = produtoRepository.findProdutoById(id);
        return produto.orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto buscarPorSku(String sku) {
        Optional<Produto> produto = produtoRepository.findProdutoBySku(sku);
        return produto.orElseThrow(() -> new RuntimeException("Produto com SKU " + sku + " não encontrado"));
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContaining(nome);
    }

    public List<Produto> buscarPorFaixaDePreco(double minPreco, double maxPreco) {
        return produtoRepository.findByPrecoBetween(minPreco, maxPreco);
    }

    public List<Produto> buscarPorNomeEPreco(String nome, double minPreco, double maxPreco) {
        return produtoRepository.findByNomeContainingAndPrecoBetween(nome, minPreco, maxPreco);
    }

    public Produto criarOuAtualizarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(Long id) {
        Optional<Produto> produto = produtoRepository.findProdutoById(id);
        if (produto.isPresent()) {
            produtoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Produto não encontrado para deletar");
        }
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findProdutoById(id);
        if (produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setSku(produtoAtualizado.getSku());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setQuantidadeEmEstoque(produtoAtualizado.getQuantidadeEmEstoque());
            return produtoRepository.save(produto);
        } else {
            throw new RuntimeException("Produto não encontrado para atualizar");
        }
    }
}