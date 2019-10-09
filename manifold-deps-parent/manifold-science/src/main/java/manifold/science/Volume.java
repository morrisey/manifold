package manifold.science;

import manifold.science.api.AbstractMeasure;
import manifold.science.util.Rational;

public final class Volume extends AbstractMeasure<VolumeUnit, Volume>
{
  public Volume( Rational value, VolumeUnit unit, VolumeUnit displayUnit )
  {
    super( value, unit, displayUnit );
  }

  public Volume( Rational value, VolumeUnit unit )
  {
    this( value, unit, unit );
  }

  @Override
  public VolumeUnit getBaseUnit()
  {
    return VolumeUnit.BASE;
  }

  @Override
  public Volume make( Rational value, VolumeUnit unit, VolumeUnit displayUnit )
  {
    return new Volume( value, unit, displayUnit );
  }

  @Override
  public Volume make( Rational value, VolumeUnit unit )
  {
    return new Volume( value, unit );
  }

  public Area div( Length t )
  {
    return new Area( toBaseNumber() / t.toBaseNumber(), AreaUnit.BASE, AreaUnit.get( t.getDisplayUnit() ) );
  }

  public Length div( Area area )
  {
    return new Length( toBaseNumber() / area.toBaseNumber(), LengthUnit.BASE, area.getDisplayUnit().getWidthUnit() );
  }

  public Mass times( Density density )
  {
    return new Mass( toBaseNumber() * density.toBaseNumber(), MassUnit.BASE, density.getDisplayUnit().getMassUnit() );
  }
}