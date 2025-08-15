package com.brandrobkus.abyssal_slime.util;

import com.brandrobkus.abyssal_slime.AbyssalSlime;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Items {

        public static final TagKey<Item> OOZEWOOD_LOGS =
                createTag("oozewood_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(AbyssalSlime.MOD_ID, name));
        }

    }
    public static class Blocks{
        public static final TagKey<Block> OOZEWOOD_LOGS =
                createTag("oozewood_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(AbyssalSlime.MOD_ID, name));
        }

    }
}