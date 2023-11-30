package com.develop.gpp.domain.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.develop.gpp.domain.entity.Account;
import com.develop.gpp.domain.entity.Token;
import com.develop.gpp.domain.entity.dto.LoginDTO;
import com.develop.gpp.domain.repository.TokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TokenService {
    
    private final TokenRepository repository;
    private final AccountService accountService;

    public Token login(LoginDTO dto) {
        Account account = accountService.getByLogin(dto);
        Token token = new Token();
        token.setUsername(account.getUsername());
        token.setToken(UUID.randomUUID().toString());
        token.setValid(LocalDateTime.now().plusMinutes(36000));
        return repository.save(token);
    }

    public Token validateToken(String token) {
        Optional<Token> t = repository.findByToken(token);
        if (t.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid token!");
        }
        if (LocalDateTime.now().isAfter(t.get().getValid())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Expired token!");
        }
        return t.get();
    }
}
