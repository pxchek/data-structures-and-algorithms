public class MultiSetListTestData {
    public static void main(String[] args) {
        Multiset<String> multiset = new MultiSetListImpl<>();
        multiset.add(Country.CHICAGO.toString(), 6);
        multiset.add(Country.ALABAMA.toString(), 4);
        multiset.add(Country.BOSTON.toString(), 1);
        multiset.add(Country.TEXAS.toString(), 0);

        System.out.println("Size: " + multiset.size());

        System.out.println("Contains Chicago: " + multiset.contains(Country.CHICAGO.toString()));

        multiset.removeAllCopies(Country.CHICAGO.toString());
        System.out.println("Size after removal: " + multiset.size());

        System.out.println("Contains Alabama: " + multiset.contains(Country.ALABAMA.toString()));

        multiset.removeAllCopies(Country.ALABAMA.toString());
        System.out.println("Size after removal: " + multiset.size());
    }

    private enum Country {
        CHICAGO,
        ALABAMA,
        BOSTON,
        TEXAS;

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
