package com.example.worktable.second.service;


import lombok.AllArgsConstructor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;



@Service
@AllArgsConstructor
public class MoldElecService {
    private FileReadService fileReadService;
@PostConstruct
    public void init() throws IOException, InvalidFormatException {


        Map<Integer, Map<Integer, List<String>>> mapMap = fileReadService.init("C:\\demo\\xx.xls");
        Map<Integer, List<String>> integerListMap = mapMap.get(0);

        for (Integer i : integerListMap.keySet()) {
            extracted(integerListMap, i);
        }
    }

    private void extracted(Map<Integer, List<String>> integerListMap, Integer i) {
        List<String> strings = integerListMap.get(i);
    }


}
