/**
 * JUnit test for InversionsCount.
 * 
 * @author      Bogdan Constantinescu <bog_con@yahoo.com>
 * @since       2013.07.05
 * @version     1.0
 * @link        GitHub  https://github.com/z3ppelin/InversionsCount
 * @licence     The MIT License (http://opensource.org/licenses/MIT); see LICENCE.txt
 */
import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;
import java.util.Arrays;

public class InversionsCountTest {
    protected int[] mergeV11 = {1, 2, 3, 4, 5};
    protected int[] mergeV12 = {6, 7, 8, 9, 10};
    protected int[] mergeV21;
    protected int[] mergeV22;
    protected int[] arrayToSort1 = {11, 7, 99, 34, 33, 34, 0, 100, 2};
    protected int[] arrayToSort2;
    protected int[] arrayToCountInversions = {1, 6, 3, 5, 2, 100, 34, 23, 11, 9};

    /**
     * Constructor; initializes stuffs.
     */
    public InversionsCountTest() {
        /* generate random sorted vectors */
        Random randomGenerator = new Random();
        int v1Length = 10 + randomGenerator.nextInt(100);
        int v2Length = 20 + randomGenerator.nextInt(200);
        this.mergeV21 = new int[v1Length];
        this.mergeV22 = new int[v2Length];
        this.mergeV21[0] = randomGenerator.nextInt(10000);
        this.mergeV22[0] = randomGenerator.nextInt(20000);
        for (int i = 1; i < v1Length; i++) {
            this.mergeV21[i] = this.mergeV21[i - 1] + randomGenerator.nextInt(10);
        }
        for (int i = 1; i < v2Length; i++) {
            this.mergeV22[i] = this.mergeV22[i - 1] + randomGenerator.nextInt(10);
        }

        /* generate random unsorted hopefully:) vector */
        int v3Length = 100 + randomGenerator.nextInt(200);
        this.arrayToSort2 = new int[v3Length];
        for (int i = 0; i < v3Length; i++) {
            this.arrayToSort2[i] = randomGenerator.nextInt(10000);
        }
    }
    
    /**
     * Setup fixtures.
     */
    @Before
    public void setUp() {
        InversionsCount.inversionsCount = 0;
    }

    /**
     * Test case for InversionsCount.merge();
     */
    @Test
    public void mergeTest() {
        int[] merged1 = InversionsCount.merge(this.mergeV11, this.mergeV12);
        assertEquals("merged 1 length is not ok", this.mergeV11.length + this.mergeV12.length, merged1.length);

        int[] merged2 = InversionsCount.merge(this.mergeV12, this.mergeV11);
        assertEquals("merged 2 length is not ok", this.mergeV11.length + this.mergeV12.length, merged2.length);

        assertArrayEquals("merged 1 and 2 are not equal", merged1, merged2);

        Arrays.sort(merged1);
        assertArrayEquals("merged 1|2 are not sorted", merged2, merged1);

        int[] merged3 = InversionsCount.merge(this.mergeV21, this.mergeV22);
        assertEquals("merged 3 length is not ok", this.mergeV21.length + this.mergeV22.length, merged3.length);

        int[] merged4 = InversionsCount.merge(this.mergeV22, this.mergeV21);
        assertEquals("merged 4 length is not ok", this.mergeV21.length + this.mergeV22.length, merged4.length);

        assertArrayEquals("merged 3 and 4 are not equal", merged3, merged4);

        Arrays.sort(merged3);
        assertArrayEquals("merged 3|4 are not sorted", merged3, merged4);

        int[] merged5 = InversionsCount.merge(this.mergeV11, this.mergeV22);
        assertEquals("merged 5 length is not ok", this.mergeV11.length + this.mergeV22.length, merged5.length);

        int[] merged6 = InversionsCount.merge(this.mergeV22, this.mergeV11);
        assertEquals("merged 6 length is not ok", this.mergeV22.length + this.mergeV11.length, merged6.length);

        assertArrayEquals("merged 5 and 6 are not equal", merged5, merged6);

        Arrays.sort(merged6);
        assertArrayEquals("merged 5|6 are not sorted", merged5, merged6);
    }

    /**
     * Test case for InversionsCount.mergeSort();
     */
    @Test
    public void mergeSortTest() {
        int[] sorted1 = InversionsCount.mergeSort(this.arrayToSort1);
        int[] sorted1Cloned = Arrays.copyOfRange(sorted1, 0, sorted1.length);
        Arrays.sort(sorted1Cloned);
        assertArrayEquals("sorted 1 is not sorted", sorted1, sorted1Cloned);

        int[] sorted2 = InversionsCount.mergeSort(this.arrayToSort2);
        int[] sorted2Cloned = Arrays.copyOfRange(sorted2, 0, sorted2.length);
        Arrays.sort(sorted2Cloned);
        assertArrayEquals("sorted 2 is not sorted", sorted2, sorted2Cloned);
    }
    
    /**
     * Test case for InversionsCount.inversionsCount;
     */
    @Test
    public void inversionsCountTest() {
        InversionsCount.mergeSort(this.arrayToCountInversions);
        assertEquals(15, InversionsCount.inversionsCount);
    }
}
