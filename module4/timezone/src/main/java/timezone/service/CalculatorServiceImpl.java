package timezone.service;

import timezone.bean.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Override
    public Calculator add(Calculator calculator) {
        calculator.setResult(String.valueOf(calculator.getFirst() + calculator.getSecond()));
        return calculator;
    }

    @Override
    public Calculator sub(Calculator calculator) {
        calculator.setResult(String.valueOf(calculator.getFirst() - calculator.getSecond()));
        return calculator;
    }

    @Override
    public Calculator mul(Calculator calculator) {
        calculator.setResult(String.valueOf(calculator.getFirst() * calculator.getSecond()));
        return calculator;
    }

    @Override
    public Calculator div(Calculator calculator) {
        if (calculator.getSecond() != 0) {
        calculator.setResult(String.valueOf((double)calculator.getFirst() / (double)calculator.getSecond()));
            System.out.println(calculator.getResult());
        } else {
            calculator.setResult("Phep chia cho 0 khong co ket qua");
        }
        return calculator;
    }
}
