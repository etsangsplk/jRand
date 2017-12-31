package me.xdrop.jrand.generators.person

import com.google.common.base.CharMatcher
import me.xdrop.jrand.model.person.Gender

class NameGeneratorTest extends GroovyTestCase {
    def instance = { -> new NameGenerator() }

    void testPrefix() {
        assertTrue instance().withPrefix().gen().split(" ").length == 3
    }

    void testWithMiddleName() {
        assertTrue instance().withMiddleName().gen().split(" ").length == 3
    }

    void testSeparator() {
        assertTrue instance().separator("!").gen().split("!").length == 2
    }

    void testGender() {
        assertTrue instance().gender("m").gen().split(" ")[0] in ["Mr", "Sir"]
        assertTrue instance().gender(Gender.MALE).gen().split(" ")[0] in ["Mr", "Sir"]
    }

    void testCardName() {
        assertTrue CharMatcher.javaUpperCase().matchesAllOf(instance().cardName().gen())
    }

    void testPrint() {
        println instance().gen()
        println instance().withMiddleName().gen()
        println instance().gender("male").gen()
        println instance().withPrefix().gen()
        println instance().reverseOrder().gen()
        println instance().cardName().gen()
    }
}
