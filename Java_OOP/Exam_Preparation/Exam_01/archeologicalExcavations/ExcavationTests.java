package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Test;

public class ExcavationTests {
    @Test
    public void constructor_ShouldSetSuccessfullyValues() {
        Excavation excavation = new Excavation("Misionis", 15);

        String expectedName = "Misionis";
        int expectedCapacity = 15;

        String actualName = excavation.getName();
        int actualCapacity = excavation.getCapacity();

        Assert.assertEquals(expectedCapacity, actualCapacity);
        Assert.assertEquals(expectedName, actualName);
    }
@Test(expected = NullPointerException.class)
    public void testSetNameWithException(){
    new Excavation(null, 2);
}
@Test(expected = IllegalArgumentException.class)
    public void testSetCapacityWithNegative(){
    new Excavation("Ivan", -5);
}
@Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistWithException(){
    Excavation excavation = new Excavation("Ivan", 1);
    Archaeologist archaeologist1 = new Archaeologist("Pesho", 2);
    Archaeologist archaeologist2 = new Archaeologist("Tosho", 2);
    excavation.addArchaeologist(archaeologist1);
    excavation.addArchaeologist(archaeologist2);
}
    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistNotExist(){
        Excavation excavation = new Excavation("Ivan", 0);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 2);
        excavation.addArchaeologist(archaeologist1);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArcheologistNWithSameName(){
        Excavation excavation = new Excavation("Ivan", 10);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 2);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist1);

    }
    @Test
    public void testAddArcheologist(){
        Excavation excavation = new Excavation("Ivan", 2);
        Archaeologist archaeologist1 = new Archaeologist("Pesho", 2);
        Archaeologist archaeologist2 = new Archaeologist("Tosho", 2);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertEquals(excavation.getCount(), 2);
        Assert.assertEquals(excavation.getCapacity(), 2);
    }
    @Test
    public void testRemove(){
            Excavation excavation = new Excavation("Ivan", 2);
            Archaeologist archaeologist1 = new Archaeologist("Pesho", 2);
            Archaeologist archaeologist2 = new Archaeologist("Tosho", 2);
            excavation.addArchaeologist(archaeologist1);
            excavation.addArchaeologist(archaeologist2);
           boolean isRemove = excavation.removeArchaeologist("Tosho");
           Assert.assertTrue(isRemove);
          Assert.assertEquals(excavation.getCount(), 1);
    }
    @Test
    public void testArcheologist(){
    Archaeologist archaeologist = new Archaeologist("Pesho", 2);
    Assert.assertEquals(archaeologist.getEnergy(), 2.0, 0);
    Assert.assertEquals(archaeologist.getName(), "Pesho");

    }
}
