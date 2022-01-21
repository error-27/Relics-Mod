package relics.content

import mindustry.content.Bullets
import mindustry.content.Fx
import mindustry.content.Items
import mindustry.ctype.ContentList
import mindustry.gen.Sounds
import mindustry.type.Category
import mindustry.world.Block
import mindustry.world.blocks.defense.turrets.ItemTurret
import mindustry.type.ItemStack.with;

class RelicsTurrets : ContentList {

    override fun load() {

        solo = object : ItemTurret("solo"){}.apply {
            localizedName = "Solo"
            description = "Fires single bullets at enemies, with a farther range than [gold]Duo."
            requirements(Category.turret, with(Items.copper, 35), true)
            range = 130f
            reloadTime = 22f
            ammo(Items.copper, Bullets.standardCopper,
                Items.graphite, Bullets.standardDense,
                Items.pyratite, Bullets.standardIncendiary,
                Items.silicon, Bullets.standardHoming)
            shots = 1
            spread = 2f
            shootCone = 10f
            ammoUseEffect = Fx.casing1
            alternate = false
            restitution = 0.03f
            health = 250
            inaccuracy = 1.5f
            rotateSpeed = 10f
        }

        stream = object : ItemTurret("stream"){}.apply {
            localizedName = "Stream"
            description = "Fires many bullets very quickly."
            requirements(Category.turret, with(Items.copper, 30, Items.lead, 45))
            range = 148f
            reloadTime = 7f
            ammo(Items.lead, RelicsBullets.standardCopperFast)
            shots = 1
            spread = 4f
            shootCone = 17f
            ammoUseEffect = Fx.casing1
            alternate = false
            restitution = 0.02f
            health = 280
            inaccuracy = 2.8f
            rotateSpeed = 8f
        }

        split = object : ItemTurret("split"){}.apply {
            localizedName = "Split"
            description = "Fires a spread of 7 bullets. Lower range but higher damage output than [gold]Stream."
            requirements(Category.turret, with(Items.copper, 45, Items.lead, 55))
            range = 100f
            reloadTime = 30f
            ammo(Items.lead, RelicsBullets.standardCopperFast)
            shots = 7
            spread = 6f
            shootCone = 17f
            ammoUseEffect = Fx.casing3
            alternate = false
            health = 280
            inaccuracy = 2.0f
            rotateSpeed = 8f
        }

        fragment = object : ItemTurret("fragment"){}.apply {
            localizedName = "Fragment"
            description = "Shoots bullets that explode into shrapnel."
            health = 310
            ammo(Items.coal, RelicsBullets.fragmentBullet)
            shots = 3
            spread = 9f
            shootCone = 5f
            ammoUseEffect = Fx.casing3
            inaccuracy = 9f
            targetAir = false
            reloadTime = 55f
            shootShake = 2f
            range = 220f
            shootSound = Sounds.bigshot
            shootEffect = Fx.shootBig
            requirements(Category.turret, with(Items.graphite, 120, Items.titanium, 130))
        }

        incinerate = object : ItemTurret("incinerate"){}.apply {
            localizedName = "Incinerate"
            description = "Advanced version of [gold]Scorch[white]. Very high damage, low to medium range."
            health = 440
            ammo(Items.coal, RelicsBullets.flameHot,
                Items.pyratite, RelicsBullets.pyraFlameHot)
            requirements(Category.turret, with(Items.graphite, 70, Items.titanium, 85))
            shots = 1
            range = 75f
            inaccuracy = 4f
            rotateSpeed = 8f
            recoilAmount = 0f
            targetAir = false
            reloadTime = 6f
            shootEffect = Fx.none
            shootSound = Sounds.flame2
        }
    }

    companion object{
        lateinit var solo: Block
        lateinit var stream: Block
        lateinit var split: Block
        lateinit var fragment: Block
        lateinit var incinerate: Block
    }
}