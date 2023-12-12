package profile.rest

import common.response.MyResponse
import jakarta.ws.rs.*
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response
import profile.domain.Profile
import profile.entity.ProfileEntity
import profile.service.ProfileService

@Path("/profile")
class ProfileResource(val profileService: ProfileService) {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    fun storeNewProfile(profile: Profile): Response {
        profileService.storeProfile(profile)
        return Response.status(Response.Status.CREATED).entity(profile).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/all")
    fun getAllProfiles(): List<ProfileEntity> {
        return profileService.getAllProfiles()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    fun getProfile(@HeaderParam("profileId") profileId: Int): Response {
        val profile = profileService.getProfileById(profileId)
        if (profile != null) {
            return Response.status(Response.Status.OK).entity(profile).build()
        }
        return Response.status(Response.Status.NOT_FOUND).entity(profileId).build()
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/username")
    fun checkUsernameExist(@HeaderParam("username") username: String): Profile? {
        return profileService.findByUsername(username)
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    fun deleteProfiles(@HeaderParam("profileId") profileId: Int): Response {
        val deleted = profileService.deleteProfile(profileId)
        if (deleted) {
            return Response.status(Response.Status.OK).entity(MyResponse("Denne profilen er slettet: $profileId")).build()
        }
        return Response.status(Response.Status.EXPECTATION_FAILED).entity(MyResponse("Denne profilen ble ikke slettet: $profileId")).build()
    }
}

