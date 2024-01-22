package com.oreilly.demo.json;

import java.util.List;

public record AstroResult(String message, int number, List<Assignment> people) {
}
