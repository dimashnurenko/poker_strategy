package com.poker.strategy.rest;

import com.poker.strategy.combination.CombinationProvider;
import com.poker.strategy.combination.CombinationResolver;
import com.poker.strategy.model.Card;
import com.poker.strategy.model.CardCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * The class describes special service which handles requests from client which related to defining card combination.
 *
 * @author Dmitry Shnurenko
 */
@Controller
@RequestMapping(value = "/combination")
public class CombinationService {

    @Autowired
    private CombinationResolver combinationResolver;
    @Autowired
    private CombinationProvider combinationProvider;

    @RequestMapping(value = "/define/{combinationCode}", method = RequestMethod.GET)
    public ResponseEntity<String> defineCombination(@PathVariable("combinationCode") String combinationCode) {

        CardCombination combination;
        try {
            Set<Card> cards = combinationResolver.resolve(combinationCode);

            combination = combinationProvider.getCombination(cards);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(combination.getCombinationName(), HttpStatus.OK);
    }
}
