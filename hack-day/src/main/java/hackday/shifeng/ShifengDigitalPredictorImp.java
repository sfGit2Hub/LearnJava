package hackday.shifeng;

public class ShifengDigitalPredictorImp implements DigitalPredictor {
    @Override
    public String predict(String input) {
        DigitalLine2 digitalLine = new DigitalLine2(input);
        while (digitalLine.size() > 1) {
            digitalLine = digitalLine.upLine();
        }
        try {
            return digitalLine.getResult();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

}
