package java17.ex03;

import java.util.function.BinaryOperator;

import org.junit.Test;

import java17.data.Person;

/**
 * Exercice 03 - java.util.function.BinaryOperator
 */
public class Function_03_Test
{
    //  tag::makeAChild[]
    BinaryOperator<Person> makeAChild = (father, mother) -> new Person(
            father.getFirstname() + " " + mother.getFirstname(),
            father.getLastname(), 0, null);
    //  end::makeAChild[]


    @Test
    public void test_makeAChild() throws Exception
    {
        Person father = new Person("John", "France", 25, "johndoe");
        Person mother = new Person("Aline", "Lebreton", 22, "alino");

        // TODO compléter le test pour qu'il soit passant
        Person child = makeAChild.apply(father, mother);

        assert child.getFirstname().equals("John Aline");
        assert child.getLastname().equals("France");
        assert child.getAge().equals(0);
        assert child.getPassword() == null;
    }
}