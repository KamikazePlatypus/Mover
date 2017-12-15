package com.kamikazedev.mover.entity;

import net.minecraft.server.v1_12_R1.EntityArmorStand;
import net.minecraft.server.v1_12_R1.EnumMoveType;
import net.minecraft.server.v1_12_R1.World;

public class CustomArmorStand extends EntityArmorStand {

  public CustomArmorStand(World world) {
    super(world);
  }

  @Override
  public void a(float f, float f1, float f2) {
    if (!this.isNoGravity()) {
      super.a(f, f1, f2);
    } else {
      move(EnumMoveType.SELF, motX, motY, motZ); // Give them some velocity anyways ;3
    }
  }

  @Override
  public void n() {
    if (this.isNoGravity()) {
      double motX = this.motX, motY = this.motY, motZ = this.motZ;
      super.n();
      this.motX = motX;
      this.motY = motY;
      this.motZ = motZ;
    } else super.n();
  }

}
