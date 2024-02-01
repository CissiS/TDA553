public interface Ramp {
    public boolean isRampPositioned();
    public void raise(double amount);
    public void lower(double amount);
}
