class TargetValue282 {
    private long targetValue;

    public void setTargetValue(long target) {
        this.targetValue = target;
    }

    public long getTargetValue() {
        return this.targetValue;
    }

    public static void main(String[] args) {
        TargetValue282 demo = new TargetValue282();
        demo.setTargetValue(10);

        System.out.println("The target value is: " + demo.getTargetValue());
    }
}
