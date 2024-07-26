package com.frimil.frimilcalculator.peca;

import javax.validation.*;
import java.util.Set;

public class PecaDTOValidator {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static void validate(PecaDTO pecaDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<PecaDTO>> violations = validator.validate(pecaDTO);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<PecaDTO> violation : violations) {
                sb.append(violation.getPropertyPath()).append(": ").append(violation.getMessage()).append("\n");
            }
            throw new ConstraintViolationException(sb.toString(), violations);
        }
    }
}
