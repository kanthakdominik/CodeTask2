import org.example.Block;
import org.example.CompositeBlock;
import org.example.Wall;

import java.util.Collections;
import java.util.List;

public class WallBuilder {

    static final Block concreteBlock = new Block() {
        @Override
        public String getColor() {
            return "gray";
        }

        @Override
        public String getMaterial() {
            return "concrete";
        }
    };

    static final Block gypsumBlock = new Block() {
        @Override
        public String getColor() {
            return "gray";
        }

        @Override
        public String getMaterial() {
            return "gypsum";
        }
    };

    static final Block stoneBlock = new Block() {
        @Override
        public String getColor() {
            return "gray";
        }

        @Override
        public String getMaterial() {
            return "stone";
        }
    };

    static final Block pineBlock = new Block() {
        @Override
        public String getColor() {
            return "bronze";
        }

        @Override
        public String getMaterial() {
            return "wood";
        }
    };

    static final Block oakBlock = new Block() {
        @Override
        public String getColor() {
            return "bronze";
        }

        @Override
        public String getMaterial() {
            return "wood";
        }
    };

    static final Block brickBlock = new Block() {
        @Override
        public String getColor() {
            return "red";
        }

        @Override
        public String getMaterial() {
            return "brick";
        }
    };

    static final Block plasticBlock = new Block() {
        @Override
        public String getColor() {
            return "yellow";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final Block plasticBlock2 = new Block() {
        @Override
        public String getColor() {
            return "black";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final Block plasticBlock3 = new Block() {
        @Override
        public String getColor() {
            return "blue";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final Block plasticBlock4 = new Block() {
        @Override
        public String getColor() {
            return "white";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final CompositeBlock compositeBlock = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(concreteBlock, gypsumBlock, stoneBlock);
        }

        @Override
        public String getColor() {
            return "gray";
        }

        @Override
        public String getMaterial() {
            return "multi-material";
        }
    };

    static final CompositeBlock compositeWoodenBlock = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(pineBlock, oakBlock, compositeWoodenBlock2);
        }

        @Override
        public String getColor() {
            return "bronze";
        }

        @Override
        public String getMaterial() {
            return "wood";
        }
    };

    static final CompositeBlock compositeWoodenBlock2 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return Collections.emptyList();
        }

        @Override
        public String getColor() {
            return "bronze";
        }

        @Override
        public String getMaterial() {
            return "wood";
        }
    };

    static final CompositeBlock compositePlasticBlock = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(compositePlasticBlock2);
        }

        @Override
        public String getColor() {
            return "multicolour";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final CompositeBlock compositePlasticBlock2 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(compositePlasticBlock3, plasticBlock);
        }

        @Override
        public String getColor() {
            return "multicolour";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final CompositeBlock compositePlasticBlock3 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(compositePlasticBlock4, plasticBlock2);
        }

        @Override
        public String getColor() {
            return "multicolour";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static final CompositeBlock compositePlasticBlock4 = new CompositeBlock() {
        @Override
        public List<Block> getBlocks() {
            return List.of(plasticBlock3, plasticBlock4);
        }

        @Override
        public String getColor() {
            return "multicolour";
        }

        @Override
        public String getMaterial() {
            return "plastic";
        }
    };

    static Wall build() {
        return new Wall(List.of(brickBlock, compositeWoodenBlock, compositePlasticBlock, compositeBlock));
    }

    static Wall buildEmpty() {
        return new Wall(Collections.emptyList());
    }
}
