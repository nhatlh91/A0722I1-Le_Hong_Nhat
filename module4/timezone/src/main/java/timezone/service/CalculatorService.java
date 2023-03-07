package timezone.service;

import timezone.bean.Calculator;

public interface CalculatorService {
    Calculator add(Calculator calculator);
    Calculator sub(Calculator calculator);
    Calculator mul(Calculator calculator);
    Calculator div(Calculator calculator);
}
