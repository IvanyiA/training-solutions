package week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        sites.add(site);
    }

    public int lastSell() {
        Site lastSite = sites.get(sites.size() - 1);
        int siteNumber = 0;
        if (lastSite.getEvenOdd() == 0) {
            siteNumber = 0;
        } else {
            siteNumber = -1;
        }
        for (Site site : sites) {
            if (lastSite.getEvenOdd() == site.getEvenOdd()) {
                siteNumber += 2;
            }
        }
        return siteNumber;
    }


    public FenceStat statistic(Fence fence) {
        FenceStat fenceStat = new FenceStat();
        for (Site site : sites) {
            if (site.getFence().equals(Fence.PERFECT)){
                fenceStat.setPerfect();
            }
            if (site.getFence().equals(Fence.NO_FENCE)){
                fenceStat.getNoFence();
            }
            if (site.getFence().equals(Fence.NEED_UPGRADE)){
                fenceStat.getNeedUpGrade();
            }
        }
        return fenceStat;
    }


}
