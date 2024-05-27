package src.controller;

import src.model.LixoCalculator;

public class SetorController {
    private LixoCalculator calculator;

    public SetorController(LixoCalculator calculator) {
        this.calculator = calculator;
    }

    public int calcularTotalLixo(int[] valores) {
        return calculator.calcularTotalLixo(valores);
    }
}
