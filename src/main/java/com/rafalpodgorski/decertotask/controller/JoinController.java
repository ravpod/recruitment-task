package com.rafalpodgorski.decertotask.controller;

import com.rafalpodgorski.decertotask.datasource.DataSource;
import com.rafalpodgorski.decertotask.join.impl.AddIntegerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/join")
public class JoinController {

    private final AddIntegerService addIntegerService;
    private final DataSource<List<Integer>> javaApi;
    private final DataSource<List<Integer>> randomApi;

    @Autowired
    public JoinController(AddIntegerService addIntegerService,
                          @Qualifier("javaApi") DataSource<List<Integer>> javaApi,
                          @Qualifier("randomApi") DataSource<List<Integer>> randomApi) {
        this.addIntegerService = addIntegerService;
        this.javaApi = javaApi;
        this.randomApi = randomApi;
    }

    @GetMapping()
    public ResponseEntity<Integer> getResult() {
        Integer result = addIntegerService.join(javaApi, randomApi);
        return ResponseEntity.ok(result);
    }
}
