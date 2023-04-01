package com.herobrinemod.herobrine.entities;

import com.herobrinemod.herobrine.HerobrineMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.minecraft.registry.Registries.ENTITY_TYPE;

public class EntityTypeList {
    public static final EntityType<HerobrineWarriorEntity> HEROBRINE_WARRIOR = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "herobrine_warrior"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HerobrineWarriorEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<HerobrineSpyEntity> HEROBRINE_SPY = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "herobrine_spy"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HerobrineSpyEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<HerobrineMageEntity> HEROBRINE_MAGE = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "herobrine_mage"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HerobrineMageEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<FakeHerobrineMageEntity> FAKE_HEROBRINE_MAGE = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "fake_herobrine_mage"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FakeHerobrineMageEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<HerobrineBuilderEntity> HEROBRINE_BUILDER = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "herobrine_builder"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HerobrineBuilderEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<HerobrineStalkerEntity> HEROBRINE_STALKER = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "herobrine_stalker"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HerobrineStalkerEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.8f)).build());
    public static final EntityType<?> HOLY_WATER = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "holy_water"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, (entityEntityType, world) -> new HolyWaterEntity(world)).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
    public static final EntityType<?> UNHOLY_WATER = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "unholy_water"), FabricEntityTypeBuilder.create(SpawnGroup.MISC, (entityEntityType, world) -> new UnholyWaterEntity(world)).dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());
    public static final EntityType<InfectedPigEntity> INFECTED_PIG = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "infected_pig"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InfectedPigEntity::new).dimensions(EntityDimensions.fixed(0.9f, 0.9f)).build());
    public static final EntityType<InfectedCowEntity> INFECTED_COW = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "infected_cow"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InfectedCowEntity::new).dimensions(EntityDimensions.fixed(0.9f, 1.4f)).build());
    public static final EntityType<InfectedVillagerEntity> INFECTED_VILLAGER = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "infected_villager"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InfectedVillagerEntity::new).dimensions(EntityDimensions.fixed(0.6f, 1.95f)).build());
    public static final EntityType<InfectedChickenEntity> INFECTED_CHICKEN = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "infected_chicken"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InfectedChickenEntity::new).dimensions(EntityDimensions.fixed(0.4f, 0.7f)).build());
    public static final EntityType<InfectedSheepEntity> INFECTED_SHEEP = Registry.register(ENTITY_TYPE, new Identifier(HerobrineMod.MODID, "infected_sheep"), FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, InfectedSheepEntity::new).dimensions(EntityDimensions.fixed(0.9f, 1.3f)).build());
}
