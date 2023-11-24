package com.example.academia.service.implementation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.academia.exception.BusinessRuleException;
import com.example.academia.exception.ErroAutentificacaoException;

import com.example.academia.service.UsuarioService;
import com.example.academia.usuario.Usuario;
import com.example.academia.usuario.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private UsuarioRepository repository;

	@Autowired
	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public Usuario autenticar(String email, String senha) {
		Optional<Usuario> usuarioOptional = repository.findByEmail(email);

		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();

			if (usuario.getSenha().equals(senha)) {
				return usuario;
			} else {
				throw new ErroAutentificacaoException("Senha incorreta");
			}
		} else {
			throw new ErroAutentificacaoException("Usuário não encontrado para o email informado");
		}
	}

	@Override
	@Transactional
	public Usuario cadastrar(Usuario usuario) {

		// Verifica se o e-mail já está cadastrado
		validarEmail(usuario.getEmail());

		// // Verifica se a faixa foi fornecida no objeto Usuario
		// if (usuario.getFaixa() != null && usuario.getFaixa().getId() != null) {
		// // Busca a faixa no banco de dados
		// Faixa faixa = faixaRepository.findById(usuario.getFaixa().getId())
		// .orElseThrow(() -> new BusinessRuleException("Faixa não encontrada."));
		// usuario.setFaixa(faixa);
		// }
		// Após salvar o usuário, salve o token na coluna 'token'
		// Gere o token

		// String generatedToken = gerarToken(usuario.getEmail());

		// // Associe o token ao usuário
		// usuario.setToken(generatedToken);

		// // Salve o usuário no banco de dados
		// return repository.save(usuario);

		// Gere o token utilizando a nova lógica
		String generatedToken = gerarToken();

		// Associe o token ao usuário
		usuario.setToken(generatedToken);

		// Salve o usuário no banco de dados
		return repository.save(usuario);
	}

	// private String gerarToken(String email) {
	// // Lógica para gerar um token (exemplo simples)
	// String token = "TOKEN_" + email.hashCode(); // Ajuste conforme necessário
	// return token;
	// }

	

	private String gerarToken() {
		// Utiliza a lógica para gerar um UUID como token
		UUID uuid = UUID.randomUUID();
		String token = uuid.toString().replace("-", "");
		return token;
	}

	@Override
	public void validarEmail(String email) {
		boolean exist = repository.existsByEmail(email);
		if (exist)
			throw new BusinessRuleException("Já existe um usuario cadastrado com esse email");
	}

	@Override
	public Usuario obterPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new BusinessRuleException("Usuário não encontrado"));
	}

	@Override
	public String obterNomeDaFaixa(String faixa) {
		throw new UnsupportedOperationException("Unimplemented method 'obterNomeDaFaixa'");
	}

}