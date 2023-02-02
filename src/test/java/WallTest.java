import org.example.Block;
import org.example.Wall;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class WallTest {

    private static final Wall wall = WallBuilder.build();
    private static final Wall emptyWall = WallBuilder.buildEmpty();

    @Test
    void shouldReturnCorrectCountValue() {
        assertEquals(17, wall.count());
    }

    @Test
    void shouldReturnZeroCountValue() {
        assertEquals(0, emptyWall.count());
    }

    @Test
    void shouldReturnAllBrickBlock() {
        assertThat(wall.findBlocksByMaterial("brick"), hasItems(WallBuilder.brickBlock));
    }

    @Test
    void shouldReturnAllConcreteBlock() {
        assertThat(wall.findBlocksByMaterial("concrete"), hasItems(WallBuilder.concreteBlock));
    }

    @Test
    void shouldReturnAllGypsumBlock() {
        assertThat(wall.findBlocksByMaterial("gypsum"), hasItems(WallBuilder.gypsumBlock));
    }

    @Test
    void shouldReturnAllStoneBlock() {
        assertThat(wall.findBlocksByMaterial("stone"), hasItems(WallBuilder.stoneBlock));
    }

    @Test
    void shouldReturnAllMultiMaterialBlock() {
        assertThat(wall.findBlocksByMaterial("multi-material"), hasItems(WallBuilder.compositeBlock));
    }

    @Test
    void shouldReturnAllWoodBlock() {
        assertThat(wall.findBlocksByMaterial("wood"), hasItems(WallBuilder.pineBlock, WallBuilder.oakBlock,
                WallBuilder.compositeWoodenBlock, WallBuilder.compositeWoodenBlock2));
    }

    @Test
    void shouldReturnAllPlasticBlock() {
        assertThat(wall.findBlocksByMaterial("plastic"), hasItems(WallBuilder.plasticBlock, WallBuilder.plasticBlock2,
                WallBuilder.plasticBlock3, WallBuilder.plasticBlock4, WallBuilder.compositePlasticBlock,
                WallBuilder.compositePlasticBlock2, WallBuilder.compositePlasticBlock3, WallBuilder.compositePlasticBlock4));
    }

    @Test
    void shouldReturnEmptyCollectionWhenMaterialIsUnknown() {
        assertThat(wall.findBlocksByMaterial("unknown"), is(empty()));
    }

    @Test
    void shouldReturnEmptyOptionalWhenColorIsUnknown() {
        assertThat(wall.findBlockByColor("unknown"), is(Optional.empty()));
    }

    @Test
    void shouldThrowExceptionWhenMaterialIsNull() {
        assertThrows(IllegalArgumentException.class, () -> wall.findBlocksByMaterial(null));
    }

    @Test
    void shouldThrowExceptionWhenColorIsNull() {
        assertThrows(IllegalArgumentException.class, () -> wall.findBlockByColor(null));
    }

    @Test
    void shouldReturnRedBlock() {
        testColor("red", WallBuilder.brickBlock);
    }

    @Test
    void shouldReturnYellowBlock() {
        testColor("yellow", WallBuilder.plasticBlock);
    }

    @Test
    void shouldReturnBlackBlock() {
        testColor("black", WallBuilder.plasticBlock2);
    }

    @Test
    void shouldReturnBlueBlock() {
        testColor("blue", WallBuilder.plasticBlock3);
    }

    @Test
    void shouldReturnWhiteBlock() {
        testColor("white", WallBuilder.plasticBlock4);
    }

    @Test
    void shouldReturnGrayBlock() {
        testColor("gray", WallBuilder.compositeBlock, WallBuilder.concreteBlock, WallBuilder.gypsumBlock,
                WallBuilder.stoneBlock);
    }

    @Test
    void shouldReturnMultiColourBlock() {
        testColor("multicolour", WallBuilder.compositePlasticBlock, WallBuilder.compositePlasticBlock2,
                WallBuilder.compositePlasticBlock3, WallBuilder.compositePlasticBlock4);
    }

    @Test
    void shouldReturnBronzeBlock() {
        testColor("bronze", WallBuilder.oakBlock, WallBuilder.pineBlock, WallBuilder.compositeWoodenBlock,
                WallBuilder.compositeWoodenBlock2);
    }

    private void testColor(String color, Block... acceptableBlocks) {
        assertTrue(wall.findBlockByColor(color).isPresent());
        assertThat(wall.findBlockByColor(color).get()).isIn(Arrays.asList(acceptableBlocks));
    }
}
