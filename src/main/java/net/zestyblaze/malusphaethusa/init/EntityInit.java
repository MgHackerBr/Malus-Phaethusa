package net.zestyblaze.malusphaethusa.init;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.zestyblaze.malusphaethusa.MalusPhaethusa;
import net.zestyblaze.malusphaethusa.entities.AppleCow;
import net.zestyblaze.malusphaethusa.entities.EnchantedGoldenAppleCow;
import net.zestyblaze.malusphaethusa.entities.GoldenAppleCow;

public class EntityInit {

    public static final EntityType<AppleCow> APPLE_COW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MalusPhaethusa.MOD_ID, "apple_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, AppleCow::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.4f))
                    .trackRangeBlocks(10)
                    .build()
    );

    public static final EntityType<GoldenAppleCow> GOLDEN_APPLE_COW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MalusPhaethusa.MOD_ID, "golden_apple_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, GoldenAppleCow::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.4f))
                    .trackRangeBlocks(10)
                    .build()
    );

    public static final EntityType<EnchantedGoldenAppleCow> ENCHANTED_GOLDEN_APPLE_COW = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier(MalusPhaethusa.MOD_ID, "enchanted_golden_apple_cow"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, EnchantedGoldenAppleCow::new)
                    .dimensions(EntityDimensions.fixed(0.9f, 1.4f))
                    .trackRangeBlocks(10)
                    .build()
    );

    public static void register() {
        FabricDefaultAttributeRegistry.register(APPLE_COW, AppleCow.createCowAttributes());
        FabricDefaultAttributeRegistry.register(GOLDEN_APPLE_COW, GoldenAppleCow.createCowAttributes());
        FabricDefaultAttributeRegistry.register(ENCHANTED_GOLDEN_APPLE_COW, EnchantedGoldenAppleCow.createCowAttributes());
    }

}
