package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class Wall implements Structure {
    private final List<Block> blocks;
    private final List<Block> flatBlocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
        flatBlocks = flatten(blocks);
    }

    public List<Block> flatten(List<Block> blocks) {
        List<Block> flattenBlocks = new ArrayList<>();

        for (Block block : blocks) {
            if (block instanceof CompositeBlock) {
                flattenBlocks.addAll(flatten(((CompositeBlock) block).getBlocks()));
            }
            flattenBlocks.add(block);
        }
        return flattenBlocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        if (color == null) {
            throw new IllegalArgumentException("Color is null!");
        }

        return flatBlocks.stream()
                .filter(b -> b.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        if (material == null) {
            throw new IllegalArgumentException("Material is null!");
        }

        return flatBlocks.stream()
                .filter(b -> b.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return flatBlocks.size();
    }
}
