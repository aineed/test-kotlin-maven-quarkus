package advertisement.rest

import advertisement.domain.Ad
import advertisement.service.AdService
import common.response.MyResponse
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/ad")
class AdResource(val adService: AdService) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun addNewAd(ad: Ad): Response {
        adService.storeAd(ad)
        return Response.status(Response.Status.CREATED).entity(ad).build()
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateAd(ad: Ad): Response {
        adService.storeAd(ad)
        return Response.status(Response.Status.CREATED).entity(ad).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/all")
    fun getAllAds(): List<Ad> {
        return listOf()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    fun getAd(@HeaderParam("adId") adId: Int): Response {
        val ad = adService.getAdById(adId)
        if (ad != null) {
            return Response.status(Response.Status.OK).entity(ad).build()
        }
        return Response.status(Response.Status.NOT_FOUND).entity(adId).build()
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    fun deleteAd(@HeaderParam("profileId") adId: Int): Response {
        val deleted = adService.deleteAd(adId)
        if (deleted) {
            return Response.status(Response.Status.OK).entity(MyResponse("Denne annonsen er slettet: $adId")).build()
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(MyResponse("Denne annonsen ble ikke slettet: $adId")).build()
    }
}

