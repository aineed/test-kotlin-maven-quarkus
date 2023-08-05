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
    fun addNewAdd(ad: Ad): Response {
        adService.storeProfile(ad)
        return Response.status(Response.Status.CREATED).entity(ad).build()
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateAd(ad: Ad): Response {
        adService.storeProfile(ad)
        return Response.status(Response.Status.CREATED).entity(ad).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/all")
    fun getAllProfiles(): List<Ad> {
        return listOf()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    fun getProfile(@HeaderParam("profileId") profileId: Int): Response {
        val profile = adService.getProfileById(profileId)
        if (profile != null) {
            return Response.status(Response.Status.OK).entity(profile).build()
        }
        return Response.status(Response.Status.NOT_FOUND).entity(profileId).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/username")
    fun checkUsernameExist(@HeaderParam("username") username: String): Ad? {
        return adService.findByUsername(username)
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    fun deleteProfiles(@HeaderParam("profileId") profileId: Int): Response {
        val deleted = adService.deleteProfile(profileId)
        if (deleted) {
            return Response.status(Response.Status.OK).entity(MyResponse("Denne profilen er slettet: $profileId")).build()
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(MyResponse("Denne profilen ble ikke slettet: $profileId")).build()
    }
}

