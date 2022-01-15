package relics.content

import mindustry.content.Bullets
import mindustry.content.Fx
import mindustry.content.Items
import mindustry.ctype.ContentList
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
            ammo(Items.lead, Bullets.standardCopper) // May add new bullet later. Original bullet was the same as Stone but faster.
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
            ammo(Items.lead, Bullets.standardCopper) // May add new bullet later. Original bullet same as in Stream
            shots = 7
            spread = 6f
            shootCone = 17f
            ammoUseEffect = Fx.casing3
            alternate = false
            health = 280
            inaccuracy = 2.0f
            rotateSpeed = 8f
        }
    }

    companion object{
        lateinit var solo: Block
        lateinit var stream: Block
        lateinit var split: Block
    }
}