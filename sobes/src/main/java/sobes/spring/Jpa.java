package sobes.spring;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;

public class Jpa {
    @Data
//    @Entity
//    @Table
    public class Route {
        Integer id;
//        Set<Address> addresses;
    }
//    @Service
    @RequiredArgsConstructor
    public class RoutsService {
//        private final RouteRepository routeRepository;
        public boolean isRouteHasEmptyAddresses(int routeId) {
//            Route route = routeRepository.findById(routeId).orElseThrow(() -> new ClassNotFoundException("Rout not found"));
//            Set<Address> addresses = route.getAddresses();
//            return addresses.isEmpty();
            return false;// это чтобы не краснело
        }
    }
}
